package lab8

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class forwardedMemoryTest extends FreeSpec with ChiselScalatestTester {
    "Forwarded Memory Test" in {
        test(new Forwarding).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.rAddr.poke(3.U)
            c.io.wrAddr.poke(3.U)
            c.io.wrData.poke(5.U)
            c.io.wr_en.poke(1.B)
            c.clock.step(10)
        }
    }
}