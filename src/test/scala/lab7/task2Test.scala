package lab7

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester {
    "Task 2 Test" in {
        test(new Manchester_Encoding).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.poke(1.U)
            c.io.start.poke(1.B)
            c.clock.step(10)
        }
    }
}