package lab8

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Test extends FreeSpec with ChiselScalatestTester {
    "Ex 1 Test" in {
        test(new MaskedReadWriteSmem2).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.write.poke(1.B)
            c.io.addr.poke(5.U)
            c.io.mask(3).poke(0.B)
            c.io.mask(2).poke(0.B)
            c.io.mask(1).poke(1.B)
            c.io.mask(0).poke(1.B)
            c.io.data_in(3).poke(2.U)
            c.io.data_in(2).poke(3.U)
            c.io.data_in(1).poke(2.U)
            c.io.data_in(0).poke(1.U)
            c.clock.step(10)
        }
    }
}