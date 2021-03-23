package lab2

import chisel3._ 
import chisel3.util._ 

class Mux_IO extends Bundle{
    val inA = Input(UInt(32.W))
    val inB = Input(UInt(32.W))
    val sel = Input(Bool())
    val out = Output(UInt())
}

class Mux_main extends Module{
    val io = IO(new Mux_IO)

    io.out := Mux(io.sel, io.inA, io.inB)
}