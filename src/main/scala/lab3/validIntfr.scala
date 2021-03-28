package lab3

// class DataWithoutValid extends Bundle {
//     val data_bits = Output(UInt(8.W))
// }

// val DataWithValid = Valid(new DataWithoutValid)

import chisel3._ 
import chisel3.util._ 

class Valid_Interf extends Module {
    val io = IO(new Bundle {
        val in = Flipped(Valid(UInt(8.W)))
        val out = Valid(UInt(8.W))
    })

    io.out := RegNext(io.in)
}