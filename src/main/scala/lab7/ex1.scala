package lab7

import chisel3._ 
import chisel3.util._ 

class ex1 extends Module {
    val io = IO(new Bundle{
        val in1 = Flipped(Decoupled(UInt(8.W)))
        val in2 = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })

    val q1 = Queue(io.in1, 5)
    val q2 = Queue(io.in2, 5)

    val arb = Module(new RRArbiter(UInt(), 2))

    arb.io.in(0) <> q1
    arb.io.in(1) <> q2

    io.out <> arb.io.out

}