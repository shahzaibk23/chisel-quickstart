package lab6

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class pipeTest extends FreeSpec with ChiselScalatestTester {
    "Pipe Test" in {
        test(new pipe).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.bits.poke(3.U)
            c.io.in.valid.poke(0.B)
            c.clock.step(10)
        }
    }
}