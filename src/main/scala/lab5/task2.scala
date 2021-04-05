package lab5

import chisel3._ 
import chisel3.util._ 

class DataPacket[T <: Data](gen:T) extends Bundle {
    val addr = UInt(10.W)
    val data = gen
    override def cloneType = (new DataPacket(gen)).asInstanceOf[this.type]
}

class Router[T <: Data](genIn:T, genOut:T) extends Module {
    val io = IO(new Bundle{
        val in = Input(new DataPacket(genIn))
        val out = Output(new DataPacket(genOut))
    })

    io.out <> io.in
}