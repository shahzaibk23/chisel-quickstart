package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Test extends FreeSpec with ChiselScalatestTester {
    "Ex 1 Test" in {
        test(new Fourto2Encoder).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in.poke(8.U)
            c.clock.step(10)
        }
    }
}