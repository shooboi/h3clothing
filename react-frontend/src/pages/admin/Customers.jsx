import React from 'react'
import { Header } from '../../components/admin'
import Table, { AvatarCell, SelectColumnFilter, StatusPill } from '../../components/admin/Table'
const getData = () => {
    const data = [
        {
            name: 'Jane Cooper',
            email: 'jane.cooper@example.com',
            title: 'Regional Paradigm Technician',
            department: 'Optimization',
            status: 'Active',
            role: 'Admin',
            age: 27,
            imgUrl: 'https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=4&w=256&h=256&q=60',
        },
        {
            name: 'Cody Fisher',
            email: 'cody.fisher@example.com',
            title: 'Product Directives Officer',
            department: 'Intranet',
            status: 'Active',
            role: 'Owner',
            age: 43,
            imgUrl: 'https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=4&w=256&h=256&q=60',
        },
        {
            name: 'Esther Howard',
            email: 'esther.howard@example.com',
            title: 'Forward Response Developer',
            department: 'Directives',
            status: 'Active',
            role: 'Member',
            age: 32,
            imgUrl: 'https://images.unsplash.com/photo-1520813792240-56fc4a3765a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=4&w=256&h=256&q=60',
        },
        {
            name: 'Jenny Wilson',
            email: 'jenny.wilson@example.com',
            title: 'Central Security Manager',
            department: 'Program',
            status: 'Active',
            role: 'Member',
            age: 29,
            imgUrl: 'https://images.unsplash.com/photo-1498551172505-8ee7ad69f235?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=4&w=256&h=256&q=60',
        },
        {
            name: 'Kristin Watson',
            email: 'kristin.watson@example.com',
            title: 'Lean Implementation Liaison',
            department: 'Mobility',
            status: 'Active',
            role: 'Admin',
            age: 36,
            imgUrl: 'https://images.unsplash.com/photo-1532417344469-368f9ae6d187?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=4&w=256&h=256&q=60',
        },
        {
            name: 'Cameron Williamson',
            email: 'cameron.williamson@example.com',
            title: 'Internal Applications Engineer',
            department: 'Security',
            status: 'Active',
            role: 'Member',
            age: 24,
            imgUrl: 'https://images.unsplash.com/photo-1566492031773-4f4e44671857?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=4&w=256&h=256&q=60',
        },
    ]
    return [...data, ...data, ...data]
}

const Customers = () => {
    const columns = React.useMemo(() => [
        {
            Header: "Name",
            accessor: 'name',
            Cell: AvatarCell,
            imgAccessor: "imgUrl",
            emailAccessor: "email",
        },
        {
            Header: "Title",
            accessor: 'title',
        },
        {
            Header: "Status",
            accessor: 'status',
            Cell: StatusPill,
        },
        {
            Header: "Age",
            accessor: 'age',
        },
        {
            Header: "Role",
            accessor: 'role',
            Filter: SelectColumnFilter,  // new
            filter: 'includes',
        },
    ], [])

    const data = React.useMemo(() => getData(), [])
    return (
        <div className='rounded-3xl border-radious sm:pt-16 m-3 mt-12 md:m-8 p-5 md:p-10 w-auto h-auto max-w-full max-h-full object-contain bg-white'>
            <Header category="Page" title="Customers"></Header>

            <Table columns={columns} data={data} />
        </div>
    )
}

export default Customers