package lab8

import chisel3._ 

class MaskedReadWriteSmem extends Module {
    val width:Int = 8
    val io = IO(new Bundle {
        val enable = Input(Bool())
        val write = Input(Bool())
        val addr = Input(UInt(10.W))
        val mask = Input(Vec(4, Bool()))
        val dataIn = Input(Vec(4, UInt(width.W)))
        val dataOut = Output(Vec(4, UInt(width.W)))
    })

    val mem = SyncReadMem(1024, Vec(4, UInt(width.W)))

    mem.write(io.addr, io.dataIn, io.mask)
    io.dataOut := mem.read(io.addr, io.enable)

}