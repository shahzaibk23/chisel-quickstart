package lab5

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester {
    "Task 1 Test" in {
        test(new Adder(32)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in0.poke(3.U)
            c.io.in1.poke(2.U)
            c.clock.step(10)
            c.io.sum.expect(5.U)
        }
    }
}