package lab8

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex2Test extends FreeSpec with ChiselScalatestTester {
    "Ex2 Test" in {
        test(new twoBankedMemory).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.enable.poke(1.B)
            c.io.rAddr.poke(3.U)
            c.io.wrAddr.poke(3.U)
            c.io.wrData(0).poke(4.U)
            c.io.wrData(1).poke(3.U)
            c.io.wr_en.poke(1.B)
            c.io.mask(0).poke(0.B)
            c.io.mask(1).poke(1.B)
            c.clock.step(10)
        }
    }
}