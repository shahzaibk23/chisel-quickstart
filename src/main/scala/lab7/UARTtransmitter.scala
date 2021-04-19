package lab7

import chisel3._ 
import chisel3.util._ 

case class UART_params(
    dataBits: Int = 8,
    stopBits: Int = 2,
    divisorBits: Int = 5,
    oversample: Int = 2,
    nSamples: Int = 3,
    nTxtEntries: Int = 4,
    nRxEntries: Int = 4
){
    def overSampleFactor = 1 << oversample
    require(divisorBits > oversample)
    require(overSampleFactor > nSamples)
}

class UART_Tx(c: UART_params) extends Module{
    val io = IO(new Bundle{
        val en = Input(Bool())
        val in = Flipped(Decoupled(UInt((c.dataBits).W)))
        val out = Output(Bool())
        val div = Input(UInt((c.divisorBits).W))
        val nstop = Input(UInt((c.stopBits).W))
    })

    val prescalar = RegInit(0.U((c.divisorBits).W))
    val pulse = (prescalar === 0.U)
    private val n = c.dataBits + 1

    val counter = RegInit(0.U((log2Floor(n+c.stopBits)+1).W))
    val shifter = Reg(UInt(n.W))
    val out = RegInit(true.B)
    io.out := out

    val busy = (counter =/= 0.U)
    val state1 = io.en && !busy
    val state2 = busy
    io.in.ready := state1

    when(state1){
        shifter := Cat(io.in.bits, false.B)
        counter := Mux1H(
            (0 until c.stopBits).map(i => (io.nstop === i.U) -> (n+i+2).U)
        )
    }

    when(state2){
        prescalar := Mux(pulse, (io.div - 1.U), prescalar - 1.U)

        when(pulse){
            counter := counter - (1.U)
            shifter := Cat(true.B, shifter >> 1)
            out := shifter(0)
        }

    }
}