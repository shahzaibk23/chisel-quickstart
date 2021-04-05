package lab5

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex3Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 3 Test" in {
        test(new Operator(5, UInt(32.W))(_+_)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in(0).poke(2.U)
            c.io.in(1).poke(3.U)
            c.io.in(2).poke(4.U)
            c.io.in(3).poke(5.U)
            c.io.in(4).poke(6.U)
            c.clock.step(10)
        }
    }
}