package lab5

import chisel3._ 
import chisel3.util._ 

class TypeParamMuxBundle[T <: Data] (dataType:T) extends Bundle {
    val out = Output(dataType)
    val in1 = Input(dataType)
    val in2 = Input(dataType)
    val sel = Input(Bool())
}

class eMux[T <: Data] (gen:T) extends Module {
    val io = IO(new TypeParamMuxBundle(gen))

    

    io.out := Mux(io.sel, io.in1, io.in2)
}