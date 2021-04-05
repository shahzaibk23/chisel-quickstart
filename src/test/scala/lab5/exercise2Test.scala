package lab5

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex2Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 2 Test" in {
        test(new eMux(SInt(32.W))).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in1.poke(3.S)
            c.io.in2.poke(2.S)
            c.io.sel.poke(0.B)
            c.clock.step(10)
            c.io.out.expect(2.S)
        }
    }
}