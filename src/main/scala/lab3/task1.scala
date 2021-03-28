package lab3

import chisel3._ 
import chisel3.util._ 

class LM_IO_Interface_BranchControl extends Bundle {
    val funct3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(UInt(32.W))
    val arg_y = Input(UInt(32.W))
    val br_taken = Output(Bool())
}

class BranchControl extends Module {
    val io = IO(new LM_IO_Interface_BranchControl)

    val out = Mux(io.funct3 === 0.U, io.arg_x.asSInt === io.arg_y.asSInt, 
    Mux(io.funct3 === 1.U, io.arg_x.asSInt =/= io.arg_y.asSInt, 
    Mux(io.funct3 === 3.U, io.arg_y.asSInt < io.arg_y.asSInt, 
    Mux(io.funct3 === 5.U, io.arg_x.asSInt >= io.arg_y.asSInt, 
    Mux(io.funct3 === 6.U, io.arg_x < io.arg_y,
    Mux(io.funct3 === 7.U, io.arg_x >= io.arg_y, false.B))) )))

    io.br_taken := out && io.branch

}