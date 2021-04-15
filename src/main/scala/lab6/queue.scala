package lab6

import chisel3._ 
import chisel3.util._ 

class queue extends Module {
    val io = IO(new Bundle {
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })

    val q = Queue(io.in, 5)
    io.out <> q 
}