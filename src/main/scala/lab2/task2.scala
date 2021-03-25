package lab2

import chisel3._ 
import chisel3.util._ 

class barrel_Shift extends Module {
    val io = IO(new Bundle{
        val in = Vec(4, Input(Bool()))
        val sel = Vec(2, Input(Bool()))
        val shift_type = Input(Bool())
        val out = Vec(4, Output(Bool()))
    })

    val select = Cat(io.sel(1), io.sel(0)).asUInt
    val out0 = MuxCase(false.B, Array(
        (select === 3.U) -> io.in(3),
        (select === 2.U) -> io.in(2),
        (select === 1.U) -> io.in(1),
        (select === 0.U) -> io.in(0)
    ))

    val out1 = MuxCase(false.B, Array(
        (select === 3.U) -> io.in(2),
        (select === 2.U) -> io.in(1),
        (select === 1.U) -> io.in(0),
        (select === 0.U) -> Mux(io.shift_type, io.in(3)>>1.U, io.in(3)<<1.U) 
    ))


    val out2 = MuxCase(false.B, Array(
        (select === 3.U) -> io.in(1),
        (select === 2.U) -> io.in(0),
        (select === 1.U) -> Mux(io.shift_type, io.in(3)>>1.U, io.in(3)<<1.U),
        (select === 0.U) -> Mux(io.shift_type, io.in(2)>>1.U, io.in(2)<<1.U) 
     ))

     val out3 = MuxCase(false.B, Array(
         (select === 3.U) -> io.in(0),
         (select === 2.U) -> Mux(io.shift_type, io.in(3)>>1.U, io.in(3)<<1.U),
         (select === 1.U) -> Mux(io.shift_type, io.in(2)>>1.U, io.in(2)<<1.U),
         (select === 0.U) -> Mux(io.shift_type, io.in(1)>>1.U, io.in(1)<<1.U) 
     ))

     io.out(3) := out0
     io.out(2) := out1
     io.out(1) := out2
     io.out(0) := out3

}