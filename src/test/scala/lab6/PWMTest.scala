package lab6

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class PWMTest extends FreeSpec with ChiselScalatestTester {
    "PWM Test" in {
        test(new PWM).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.clock.step(20)
        }
    }
}