package lab7

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester {
    "Task 1 Test" in {
        test(new Task1).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.f1.poke(1.B)
            c.io.f2.poke(0.B)
            c.io.r1.poke(0.B)
            c.io.r2.poke(0.B)
            c.clock.step(10)
            
        }
    }
}