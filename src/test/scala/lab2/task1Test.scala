package lab2

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 

class task1Test extends FreeSpec with ChiselScalatestTester {
    "Task 1 Test" in {
        test(new Mux5_1){ c =>
            c.io.s0.poke(1.B)
            c.io.s1.poke(0.B)
            c.io.s1.poke(1.B)
            c.io.out.expect(32.U)
        }
    }
}