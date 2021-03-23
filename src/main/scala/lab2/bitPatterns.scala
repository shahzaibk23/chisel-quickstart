package lab2

import chisel3._
import chisel3.util._ 

class bitPatterns extends Module {
    val io = IO(new Bundle{
        val out = Output(Bool())
    })

    def opCode = BitPat("b000?????1100011")

    when(opCode === "b000110001100011".U){
        io.out := 1.B
    }.otherwise{
        io.out := 0.B
    }
}