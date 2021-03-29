package lab3

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class Task2Test extends FreeSpec with ChiselScalatestTester {
    "Task 2 Test" in {
        test(new ImmdValGen).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.instr.poke("h01700013".U)
            c.clock.step(10)
            c.io.immd_se.expect(23.U)
        }
    }
}