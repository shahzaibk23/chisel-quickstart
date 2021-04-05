package lab5

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 1 Test" in {
        test(new ex1ALU(64)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>

            c.io.arg_x.poke(3.U)
            c.io.arg_y.poke(2.U)
            c.io.alu_oper.poke(2.U)
            c.clock.step(10)
            c.io.alu_out.expect(5.U)

        }
    }
}