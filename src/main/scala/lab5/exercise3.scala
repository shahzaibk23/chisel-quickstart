package lab5

import chisel3._ 
import chisel3.util._ 

class Operator[T <: Data](n:Int, generic:T)(op: (T,T) => T) extends Module {
    require(n > 0)

    val io = IO(new Bundle{
        val in = Input(Vec(n,generic))
        val out = Output(Vec(n,generic))
    })

    for(i<- 0 until n-1){
        io.out(i) := op(io.in(i), io.in(i+1))
    }
    io.out(n-1) := io.in.reduce(op)
}