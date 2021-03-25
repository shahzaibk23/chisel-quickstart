package lab1

import chisel3._
import chisel3.util._

class counter_up_down(n:Int) extends Module {
    val io = IO(new Bundle{
        val data_in = Input(UInt(n.W))
        val reload = Input(Bool())
        val out = Output(Bool())
        // val counter = Output(UInt(n.W))
    })

    val counter = RegInit(0.U(n.W))
    val max_count = RegInit(6.U(n.W))

    val reverse = RegInit(0.B)

    when(reverse === 1.B && counter === 0.U){
        io.out := 1.B
    }.otherwise{
        io.out := 0.B
    }

    def countUpper(max:UInt)={
        // io.out := 0.B
        when(counter === max){
            when(io.reload === true.B){
                reverse := true.B
            }
                // reverse := true.B
                io.out := 1.B
                counter := counter - 1.U
                // countLower
        }.otherwise{
            when(reverse === 1.B){
                counter := counter - 1.U
            }.otherwise{
                counter := counter + 1.U
            }
            
        } 

    }

    countUpper(max_count)
    
}