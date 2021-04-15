package lab6

import chisel3._ 
import chisel3.util._ 

class pipe extends Module {
    val io = IO(new Bundle {
        val in = Flipped(Valid(UInt(8.W)))
        val out = Valid(UInt(8.W))
    })

    io.out := Pipe(io.in, 5)
}