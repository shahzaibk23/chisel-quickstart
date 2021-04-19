package lab7

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 1 Test" in {
        test(new ex1).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in1.bits.poke(3.U)
            c.io.in1.valid.poke(1.B)
            c.io.in2.bits.poke(6.U)
            c.io.in2.valid.poke(1.B)
            c.clock.step(10)
        }
    }
}