package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex2Test extends FreeSpec with ChiselScalatestTester {
    "Ex 2 Test" in {
        test(new ex2ALU).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.in_A.poke(5.U)
            c.io.in_B.poke(3.U)
            c.io.alu_Op.poke(2.U)
            c.clock.step(10)
        }
    }
}