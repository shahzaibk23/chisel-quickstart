package lab6

import chisel3._ 
import chisel3.util._ 

class counter_with_xor(val max: Int = 1) extends Module {
    val io = IO(new Bundle {
        val out = Output(UInt(log2Ceil(max).W))
    })

    val counter = RegInit(0.U(log2Ceil(max).W))

    when(counter(log2Ceil(max)-1).asBool ^ 0.B){
        counter := 0.U
    }.otherwise{
        counter := counter + 1.U
    }

    io.out := counter
}