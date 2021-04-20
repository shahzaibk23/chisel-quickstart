package lab8

import chisel3._ 
import chisel3.util._ 

class MaskedReadWriteSmem2 extends Module {
    val width: Int = 8
    val io = IO(new Bundle {
        // val enable = Input(Bool())
        val write = Input(Bool())
        val addr = Input(UInt(10.W))
        val mask = Input(Vec(4, Bool()))
        val data_in = Input(Vec(4, UInt(width.W)))
        val dataOut = Output(Vec(4, UInt(width.W)))
    })

    val mem = SyncReadMem(1024, UInt((width*4).W))
    // mem.write(io.addr, Cat(io.data_in(3), io.data_in(2), io.data_in(1), io.data_in(0)))
    mem.write(io.addr, Cat(
        Mux(io.mask(3), io.data_in(3), Fill(width, 0.U)),
        Mux(io.mask(2), io.data_in(2), Fill(width, 0.U)),
        Mux(io.mask(1), io.data_in(1), Fill(width, 0.U)),
        Mux(io.mask(0), io.data_in(0), Fill(width, 0.U))
    ))
    io.dataOut(0) := mem.read(io.addr)(width, 0)
    io.dataOut(1) := mem.read(io.addr)((width*2) -1, width)
    io.dataOut(2) := mem.read(io.addr)((width*3) -1, width*2)
    io.dataOut(3) := mem.read(io.addr)((width*4) -1, width*3)




    



}