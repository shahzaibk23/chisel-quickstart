package lab3
import chisel3._ 
import chisel3.util._ 

class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input(UInt(32.W))
    val immd_se = Output(UInt(32.W))
}

class ImmdValGen extends Module {
    val io = IO(new LM_IO_Interface_ImmdValGen)
    val opCode = io.instr(0,6)
    Mux(opCode === "b0010011".U, Cat(Fill(20,io.instr(31)), io.instr(31,20)), // i
    Mux(opCode === "b0100011".U, Cat(Fill(20,io.instr(31)),io.instr(31,25), io.instr(11,7)), // s
    Mux(opCode === "b0110111".U, Cat(Fill(12, io.instr(31)),io.instr(31,12) )  << "hc".U, // lui
    Mux(opCode === "b1100011".U, Cat(Fill(19,io.instr(31)), io.instr(31,25), io.instr(11,7), 0.U) , //b
    Mux(opCode === "b1101111".U, Cat( Fill(11,io.instr(31)), io.instr(31,12), 0.U), false.B)))))//j

}