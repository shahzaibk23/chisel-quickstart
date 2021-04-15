package lab6

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex4Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 4 Test" in {
        test(new ex4).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.valid.poke(1.B)
            c.io.in.bits.poke(4.U)
            c.clock.step(20)
            c.io.out.ready.poke(1.B)
            c.io.out.bits.expect(4.U)
        }
    }
}