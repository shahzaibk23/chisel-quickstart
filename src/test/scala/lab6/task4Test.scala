package lab6

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class task4Test extends FreeSpec with ChiselScalatestTester {
    "Task 4 Test" in {
        test(new up_down_counter).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.up_down.poke(1.B)
            c.clock.step(20)
            c.io.up_down.poke(0.B)
            c.clock.step(20)
        }
    }
}