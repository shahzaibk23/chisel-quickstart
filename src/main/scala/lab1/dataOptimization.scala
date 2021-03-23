package lab1

import chisel3._

class AdderWithOffset extends Module {
    val io = IO(new Bundle{
        val x = Input(SInt(16.W))
        val y = Input(UInt(16.W))
        val z = Output(UInt(16.W))
    })

    val y1 = (23.U).asSInt
    val in1 = io.x + y1
    io.z := in1.asUInt + io.y
    // val i = (23.U).asSInt + 2.S(16.W)
    // io.z := i.asUInt + 3.U(16.W)
    
}

// println((new chisel3.stage.ChiselStage).emitVerilog(new AdderWithOffset))

