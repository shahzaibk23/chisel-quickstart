package lab2

import chisel3._ 
import chisel3.util._ 

class LM_IO_Interfaces extends Bundle {
    val s0 = Input(Bool())
    val s1 = Input(Bool())
    val s2 = Input(Bool())
    val out = Output(UInt(32.W))
}

class Mux5_1 extends Module {
    val io = IO(new LM_IO_Interfaces)

    val sel = Cat(io.s0,io.s1,io.s2).asInstanceOf[UInt]

    // io.out := MuxLookup(sel, 0.U, Array(
    //     ("b000".U) -> 0.U,
    //     ("b001".U) -> 8.U,
    //     ("b010".U) -> 16.U,
    //     ("b011".U) -> 24.U,
    //     (BitPat("b1??")) -> 32.U,
    // ))

    io.out := MuxCase(false.B, Array(
        (sel === "b000".U) -> 0.U,
        (sel === "b001".U) -> 8.U,
        (sel === "b010".U) -> 16.U,
        (sel === "b011".U) -> 24.U,
        (sel === BitPat("b1??")) -> 32.U
    ))

}