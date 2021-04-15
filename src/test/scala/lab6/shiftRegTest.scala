package lab6

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class shiftRegTest extends FreeSpec with ChiselScalatestTester {
    "Shift Register Test" in {
        test(new shiftRegister(4)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.poke(1.B)
            c.clock.step(10)
        }
    }
}