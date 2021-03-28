package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class Task1Test extends FreeSpec with ChiselScalatestTester {
    "Task 1 Test" in {
        test(new BranchControl).withAnnotations(Seq(VerilatorBackendAnnotation)) {c => 
            c.io.funct3.poke("b111".U)
            c.io.branch.poke(true.B)
            c.io.arg_x.poke(3.U)
            c.io.arg_y.poke(2.U)
            c.clock.step(10)
        }
    }
}