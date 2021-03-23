package lab2

import chisel3._ 
import chisel3.util._ 

class exercise1 extends Module {
    val io = IO(new Bundle{
        val inA = Input(UInt(32.W))
        val inB = Input(UInt(32.W))
        val sel = Input(UInt(1.W))
        val out = Output(UInt(32.W))
    })

    io.out := io.inA & Fill(32,io.sel) | io.inB & Fill(32,(~io.sel))

}