package lab8

import chisel3._ 
import chisel3.util._ 

class Forwarding extends Module {
    val io = IO(new Bundle {
        val out = Output(UInt(32.W))
        val rAddr = Input(UInt(10.W))
        val wrAddr = Input(UInt(10.W))
        val wrData = Input(UInt(32.W))
        val wr_en = Input(Bool())
    })

    val memory = SyncReadMem(1024,UInt(32.W))
    val wrDataReg = RegNext(io.wrData)
    val doForwarding = RegNext(io.wrAddr === io.rAddr && io.wr_en)
    val memData = memory.read(io.rAddr)
    when(io.wr_en){
        memory.write(io.wrAddr, io.wrData)
    }

    io.out := Mux(doForwarding, wrDataReg, memData)
}