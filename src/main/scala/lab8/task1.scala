package lab8

import chisel3._ 
import chisel3.util._ 

class memory_assignment extends Module {
    val io = IO(new Bundle{
        val memory_out = Vec(4, Output(UInt(32.W)))
        val requestor = Vec(4, Flipped(Decoupled(UInt(32.W))))
        val read_addr = Input(UInt(5.W))
        val write_Addr = Input(UInt(5.W))
    })

    val mem = SyncReadMem(1024, Vec(4, UInt(4.W)))

    val q1 = Queue(io.requestor(0))
    val q2 = Queue(io.requestor(1))
    val q3 = Queue(io.requestor(2))
    val q4 = Queue(io.requestor(3))

    val arb = Module(new Arbiter(UInt(), 4))
    arb.io.out.ready := 1.B

    arb.io.in(0) <> q1
    arb.io.in(1) <> q2
    arb.io.in(2) <> q3
    arb.io.in(3) <> q4

    val r = Reg(Vec(4, UInt()))
    r(0) := Mux(io.requestor(0).valid, arb.io.out.bits, 0.U)
    r(1) := Mux(io.requestor(1).valid, arb.io.out.bits, 0.U)
    r(2) := Mux(io.requestor(2).valid, arb.io.out.bits, 0.U)
    r(3) := Mux(io.requestor(3).valid, arb.io.out.bits, 0.U)

    mem.write(io.write_Addr, r)
    io.memory_out := mem.read(io.read_addr)


}