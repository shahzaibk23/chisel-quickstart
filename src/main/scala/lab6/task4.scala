package lab6

import chisel3._ 
import chisel3.util._ 

class up_down_counter(val max:Int = 10) extends Module {
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
        val up_down = Input(Bool())
    })

    // val counter = if(io.up_down == 1.B) RegInit(0.U(log2Ceil(max).W)) else RegInit(max.U(log2Ceil(max).W))

    // val u = io.up_down
    // val counter = Mux(io.up_down, RegInit(0.U(log2Ceil(max).W)), RegInit(max.U(log2Ceil)))

    // if(io.up_down == true){
    //     val counter = RegInit(0.U(log2Ceil(max).W))
    // } else {
    //     val counter = RegInit(max.U(log2Ceil(max).W))
    // }

    val counter = RegInit(0.U)


    when(io.up_down === 1.B && counter =/= max.U){
        counter := counter + 1.U
    }.elsewhen(io.up_down === 0.B && counter =/= 0.U){
        counter := counter - 1.U
    }

    io.out := counter

}