package lab6

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class counterTest extends FreeSpec with ChiselScalatestTester {
    "Counter Test" in {
        test(new counter(10,2)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.clock.step(20)
        }
    }
}