package lab6

import chisel3._ 
import chisel3.util._ 

class ex4 extends Module {
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })

    val queue1 = Queue(io.in, 5)
    val queue2 = Queue(queue1, 5)

    queue1.nodeq()
    queue2.nodeq()

    when(queue2.valid && io.out.ready){
        // io.out.bits := queue2.deq().bits
        // io.out.valid := queue2.deq().valid
        io.out.enq(queue2.deq())
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
    }

}