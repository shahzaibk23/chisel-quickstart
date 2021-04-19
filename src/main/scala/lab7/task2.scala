package lab7

import chisel3._ 
import chisel3.util._ 

class Manchester_Encoding extends Module {
    val io = IO(new Bundle {
        val in = Input(UInt(1.W))
        val start = Input(Bool())
        val out = Output(UInt(8.W))
        val flag = Output(UInt(1.W))
    })

    val s0 :: s1 :: Nil = Enum(2) // s0 - off state && s1 = on state
    val state = RegInit(s0)
    val reg = RegInit(0.U(8.W))

    io.out := reg
    io.flag := state

    switch(state){
        is(s0){
            when(io.start){
                state := s1
            }.otherwise{
                io.flag := 0.U
                io.out := reg
            }            
        }
        is(s1){
            when(!io.start){
                state := s0
            }.otherwise{
                io.flag := 1.U
                reg := reg << 1 | io.in
                io.out := reg
            }
        }
    }

}