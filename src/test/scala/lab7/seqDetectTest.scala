package lab7

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class seqDetectTest extends FreeSpec with ChiselScalatestTester {
    "Sequence Detector Test" in {
        test(new Detect_Seq).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.poke(0.B)
            c.clock.step(1)
            c.io.in.poke(1.B)
            c.clock.step(1)
            c.io.in.poke(1.B)
            c.clock.step(1)
            c.io.in.poke(0.B)
            c.clock.step(1)
        }
    }
}