package lab8

import org.scalatest._
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class Asynch_MemTest extends FreeSpec with ChiselScalatestTester {
    "Asynch Mem Test" in {
        test(new Asynch_Mem).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.data_in(0).poke(3.U)
            c.io.data_in(1).poke(4.U)
            c.io.data_in(2).poke(5.U)
            c.io.data_in(3).poke(6.U)
            c.io.data_selector.poke(1.U)
            c.io.addr.poke(5.U)
            c.io.wr_en.poke(1.B)
            c.clock.step(10)
        }
    }
}