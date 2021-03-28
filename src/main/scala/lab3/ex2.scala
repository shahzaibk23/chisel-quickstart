package lab3

import chisel3._ 
import chisel3.util._ 

import ALUOP._

class ex2ALU extends Module with Config{
    val io = IO(new ALUIO)
    val sum = io.in_A + Mux(io.alu_Op(0), -io.in_B, io.in_B)
    val cmp = Mux(io.in_A(WLEN-1) === io.in_B(WLEN-1), sum(WLEN-1),
                Mux(io.alu_Op(1), io.in_B(WLEN-1), io.in_A(WLEN-1)))
    val shamt = io.in_B(4,0).asUInt
    val shin = Mux(io.alu_Op(3), io.in_A, Reverse(io.in_A))
    val shiftr = (Cat(io.alu_Op(0) && shin(WLEN-1), shin).asSInt >> shamt)(WLEN-1,0)
    val shitfl = Reverse(shiftr)
    io.out := 0.U
    switch (io.alu_Op){
        is (ALU_ADD){
            io.out := sum
        }
        is (ALU_SUB){
            io.out := sum
        }
        is (ALU_SLT){
            io.out := cmp
        }
        is (ALU_SLTU){
            io.out := cmp
        }
        is (ALU_SRA){
            io.out := shiftr
        }
        is (ALU_SRL){
            io.out := shiftr
        }
        is (ALU_SLL){
            io.out := shitfl
        }
        is (ALU_AND){
            io.out := io.in_A & io.in_B
        }
        is (ALU_OR){
            io.out := io.in_A | io.in_B
        }
        is(ALU_XOR){
            io.out := io.in_A ^ io.in_B
        }
        is (ALU_COPY_A){
            io.out := io.in_A
        }
        is(ALU_COPY_B){
            io.out := io.in_B
        }
    }

    // io.out := out
    io.sum := sum

}