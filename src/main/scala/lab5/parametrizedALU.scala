package lab5

import chisel3._ 
import chisel3.util._ 

class ParamALU(width_parameters: Int) extends Module {
    val io = IO(new IO_Interface(width_parameters))

    io.alu_out := 0.U
    val index = log2Ceil(width_parameters)

    switch(io.alu_oper){
        is("b0000".U){
            io.alu_out := io.arg_x & io.arg_y // and
        }
        is("b0001".U){
            io.alu_out := io.arg_x | io.arg_y // or
        }
        is("b0010".U){
            io.alu_out := io.arg_x + io.arg_y // add
        }
        is("b0110".U){
            io.alu_out := io.arg_x - io.arg_y //sub
        }
        is("b0011".U){
            io.alu_out := io.arg_x ^ io.arg_y //xor
        }
        is("b0100".U){
            io.alu_out := io.arg_x << io.arg_y(index - 1, 0) //sll
        }
        is("b0101".U){
            io.alu_out := io.arg_x >> io.arg_y(index - 1, 0) //srl
        }
        is("b0111".U){
            io.alu_out := (io.arg_x.asSInt >> io.arg_y(index - 1, 0)).asUInt //sra
        }
        is("b1000".U){
            io.alu_out := io.arg_x.asSInt < io.arg_y.asSInt //slt
        }
        is("b1001".U){
            io.alu_out := io.arg_x < io.arg_y //sltu
        }
    }
}

class IO_Interface(width:Int) extends Bundle {
    val alu_oper = Input(UInt(width.W))
    val arg_x = Input(UInt(width.W))
    val arg_y = Input(UInt(width.W))
    val alu_out = Output(UInt(width.W))
}