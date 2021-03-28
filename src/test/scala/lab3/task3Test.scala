package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class Task3Test extends FreeSpec with ChiselScalatestTester {
    "Task 3 Test" in {
        test(new decoder_with_valid).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
            c.io.in.poke(3.U)
            c.clock.step(10)
        }
    }
}