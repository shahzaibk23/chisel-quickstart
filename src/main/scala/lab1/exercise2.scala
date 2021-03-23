package lab1

import chisel3._

class Counter4(counterBits: Int) extends Module {
    val io = IO(new Bundle {
        val result  = Output(Bool())
    })

    val max = (1.U << counterBits) - 1.U
    val count = RegInit(0.U(4.W))

    when(count === max){
        // count := 0.U
        val a =DontCare
    }.otherwise{
        count := count + 1.U
    }

    when(count(3.U) === 1.U){
        count := 0.U
    }

    io.result := count(3.U)
    println(s"counter created with max value $max")
}