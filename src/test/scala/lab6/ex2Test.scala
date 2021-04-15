package lab6

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex2Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 2 Test" in {
        test(new ex2counter(10)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.clock.step(10)
        }
    }
}