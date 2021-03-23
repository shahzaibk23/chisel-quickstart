package lab2

import org.scalatest._ 
import chiseltest._ 
import chisel3._ 

class exercise1Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 1 Test " in {
        test(new exercise1){ c =>
            c.io.inA.poke(12.U)
            c.io.inB.poke(13.U)
            c.io.sel.poke(0.U)
            c.clock.step(1)
            c.io.out.expect(13.U)
        }
    }
}